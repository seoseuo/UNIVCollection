package project;

import java.io.IOException;
import java.util.List;

import org.ws4d.coap.core.enumerations.CoapMediaType;
import org.ws4d.coap.core.rest.BasicCoapResource;
import org.ws4d.coap.core.rest.CoapData;
import org.ws4d.coap.core.tools.Encoder;

import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CDevice;
import com.pi4j.io.i2c.I2CFactory;
import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;

import week7.I2CLCD;

public class LCD extends BasicCoapResource{
   private String state = "off";
   private I2CBus bus;
   private I2CDevice dev;
   private I2CLCD lcd;


   private LCD(String path, String value, CoapMediaType mediaType){
      super(path, value, mediaType);
   }

   public LCD() {
      this("/lcd", "TEXT", CoapMediaType.text_plain);
      
      try {
         bus = I2CFactory.getInstance(I2CBus.BUS_1);
         dev = bus.getDevice(0x27);
         lcd = new I2CLCD(dev);
         lcd.init();
         lcd.backlight(true);
      } catch(UnsupportedBusNumberException e) {
         e.printStackTrace();
      } catch(IOException e) {
         e.printStackTrace();
      }

   }

   @Override
   public synchronized CoapData get(List<String> query, List<CoapMediaType> mediaTypesAccepted) {
      return get(mediaTypesAccepted);
   }
   
   @Override
   public synchronized CoapData get(List<CoapMediaType> mediaTypesAccepted) {
      return new CoapData(Encoder.StringToByte(this.state), CoapMediaType.text_plain);
   }

   @Override
   public synchronized boolean post(byte[] data, CoapMediaType type) {
      return this.setValue(data);
   }

   @Override
   public synchronized boolean put(byte[] data, CoapMediaType type) {
      return this.setValue(data);
   }
   
   @Override
   public synchronized boolean setValue(byte[] value) {
      this.state = Encoder.ByteToString(value);
      lcd.clear();
      lcd.display_string(this.state,1);
      return true;
   }

   @Override
   public synchronized String getResourceType() {
      return "Raspberry pi 4 LCD";
   }

}