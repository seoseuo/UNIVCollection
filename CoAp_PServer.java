package project;

import org.ws4d.coap.core.rest.CoapResourceServer;



public class CoAp_PServer {
   private static CoAp_PServer coapServer;
   private CoapResourceServer resourceServer;
   
   public static void main(String[] args) {
      coapServer = new CoAp_PServer();
      coapServer.start();
   }

   public void start() {
	      System.out.println("===Run CoAP Server ===");

	      // create server
	      if (this.resourceServer != null)   
	      this.resourceServer.stop();
	      this.resourceServer = new CoapResourceServer();

	      // initialize resource
	      LED led = new LED();
	      Temp_Sensor temp_sensor = new Temp_Sensor();
	      LCD lcd = new LCD();
	      Buzzer buzzer = new Buzzer();
	      
	      
	      // CoapResourceServer에 observe하려는 resource 등록 -> 온도 측정을 봐야하므로 temp_sensor
	      temp_sensor.registerServerListener(resourceServer);
	      
	      // add resource to server
	      this.resourceServer.createResource(temp_sensor);
	      this.resourceServer.createResource(led);
	      this.resourceServer.createResource(lcd);
	      this.resourceServer.createResource(buzzer); //
	      
	      //this.resourceServer.createResource(buzzer);
	            
	      // run the server
	      try {
	         this.resourceServer.start();
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      while (true) {
	         try {
	            Thread.sleep(5000); //5초에 한번씩 변동값 기입
	            temp_sensor.optional_changed();
	         } catch (Exception e) {
	            e.printStackTrace();
	         }
	      }

	   }
}
