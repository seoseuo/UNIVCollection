package project;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.wiringpi.Gpio;
import com.pi4j.wiringpi.GpioUtil;

public class PJDHT11 {
	private static final int MAXTIMINGS = 85; // Data 교환이 이루어질 수 있는 최대 시간 정의
    private final int[] dht11_f = {0, 0, 0, 0, 0}; //dht11 data format (5 bytes)    

    public PJDHT11() {
//    	 Setup wiringPi
    	if (Gpio.wiringPiSetup() == -1) {
    		System.out.println(" ==>> GPIO SETUP FAILED");
    		return;
    	}
    	GpioUtil.export(15, GpioUtil.DIRECTION_OUT);
    }

    public float[] getData(final int pin) {
    	int laststate = Gpio.HIGH; // Signal 상태 변화를 알기 위해 기존 상태 저장
    	int j = 0; // 수신한 Bit의 index counter
    	float h = -99; // 습도 (%)
    	float c = -99; // 섭씨 온도 (°C)
    	float f = -99; // 화씨 온도 (°F)

    	// Integral RH, Decimal RH, Integral T, Decimal T, Checksum
    	dht11_f[0] = dht11_f[1] = dht11_f[2] = dht11_f[3] = dht11_f[4] = 0;    	

    	// 1. DHT11 센서에게 start signal 전달
    	Gpio.pinMode(pin, Gpio.OUTPUT);
    	Gpio.digitalWrite(pin, Gpio.LOW);
    	Gpio.delay(18); // 18 ms

    	// 2. Pull-up -> 수신 모드로 전환 -> 센서의 응답 대기
    	Gpio.digitalWrite(pin, Gpio.HIGH);
    	Gpio.pinMode(pin, Gpio.INPUT);

    	// 3. 센서의 응답에 따른 동작
    	for (int i = 0; i < MAXTIMINGS; i++) {
    		int counter = 0;
    		while (Gpio.digitalRead(pin) == laststate) { // GPIO pin 상태가 바뀌지 않으면 대기
    			counter++;
    			Gpio.delayMicroseconds(1);
    			if (counter == 255) {
    				break;
    			}
    		}
    		laststate = Gpio.digitalRead(pin);
    		if (counter == 255) {
    			break;
    		}

    		// 각각의 bit 데이터 저장
    		if (i >= 4 && i % 2 == 0) { // ignore first 3 transitions
    			// Shove incoming each bit into dht11_f 
    			dht11_f[j / 8] <<= 1; // 0 bit 
    			if (counter > 16) {
    				dht11_f[j / 8] |= 1; // 1 bit
    			}
    			j++;
    		}
    	}

    	// Checksum 확인
    	// Check we read 40 bits (8bit x 5 ) + verify checksum in the last
    	if (j >= 40 && getChecksum()) {
    		h = (float) ((dht11_f[0] << 8) + dht11_f[1]) / 10;
    		if (h > 100) {
    			h = dht11_f[0]; // for DHT11
    		}
    		c = (float) (((dht11_f[2] & 0x7F) << 8) + dht11_f[3]) / 10;
    		if (c > 125) {
    			c = dht11_f[2]; // for DHT11
    		}
    		if ((dht11_f[2] & 0x80) != 0) {
    			c = -c;
    		}
    		f = c * 1.8f + 32;
    		System.out.println("Temperature = " + c + "*C");
    	}
    	else {
    		System.out.println("Checksum Error");
    	}

    	float[] result = {h,c,f};
    	return result;        
    }

    private boolean getChecksum() {
    	return dht11_f[4] == (dht11_f[0] + dht11_f[1] + dht11_f[2] + dht11_f[3] & 0xFF);
    }
    
} 	
