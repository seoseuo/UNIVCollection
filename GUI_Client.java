package project;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.ws4d.coap.core.CoapClient;
import org.ws4d.coap.core.CoapConstants;
import org.ws4d.coap.core.connection.BasicCoapChannelManager;
import org.ws4d.coap.core.connection.api.CoapChannelManager;
import org.ws4d.coap.core.connection.api.CoapClientChannel;
import org.ws4d.coap.core.enumerations.CoapMediaType;
import org.ws4d.coap.core.enumerations.CoapRequestCode;
import org.ws4d.coap.core.messages.api.CoapRequest;
import org.ws4d.coap.core.messages.api.CoapResponse;
import org.ws4d.coap.core.rest.CoapData;
import org.ws4d.coap.core.tools.Encoder;

public class GUI_Client extends JFrame implements CoapClient{
   private static final boolean exitAfterResponse = false;
   
   JButton btn_get = new JButton("작동 부품 목룍");
   JButton btn_put = new JButton("원격 조작");
   JButton btn_observe = new JButton("현재 온도 확인");
   
   JLabel path_label = new JLabel("기기명");
   JTextArea path_text = new JTextArea("/.well-known/core", 1,1);    
   JLabel payload_label = new JLabel("부품 조작 키");
   JTextArea payload_text = new JTextArea("", 1,1);      
   
   JTextArea display_text = new JTextArea();
   JScrollPane display_text_jp  = new JScrollPane(display_text);
   JLabel display_label = new JLabel("Display");
   
   CoapClientChannel clientChannel = null;
   
   
   
   
   public GUI_Client (String serverAddress, int serverPort) {
      
      super("무인 화재 경보 시스템");
         
      this.setLayout(null);
      String sAddress = serverAddress;
      int sPort = serverPort;

      CoapChannelManager channelManager = BasicCoapChannelManager.getInstance();

      

      try {
         clientChannel = channelManager.connect(this, InetAddress.getByName(sAddress), sPort);
      } catch (UnknownHostException e) {
         e.printStackTrace();
         System.exit(-1);
      }


      if (null == clientChannel) {
         return;
      }

      //btn
      btn_get.setBounds(20, 670, 150, 50);
      btn_put.setBounds(180, 670, 100, 50);

      btn_observe.setBounds(290, 670, 150, 50);
      
      btn_get.addActionListener(new ActionListener() { //리소스 정보들을 확인한다.
         @Override
         public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            String path = path_text.getText();
            String payload = payload_text.getText();            
            CoapRequest request = clientChannel.createRequest(CoapRequestCode.GET, path, true);
            displayRequest(request);
            clientChannel.sendMessage(request);
         }
      });
      btn_put.addActionListener(new ActionListener() { //
         @Override
         public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            String path = path_text.getText();
            String payload = payload_text.getText();
            CoapRequest request = clientChannel.createRequest(CoapRequestCode.PUT, path, true);
            request.setPayload(new CoapData(payload, CoapMediaType.text_plain));
            displayRequest(request);
            clientChannel.sendMessage(request);
         }
      });

      
      btn_observe.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            String path = path_text.getText();
            String payload = payload_text.getText();
            CoapRequest request = clientChannel.createRequest(CoapRequestCode.GET, path, true);
            
            request.setToken(Encoder.StringToByte("obToken"));//토큰값 설정
            request.setObserveOption(0);
            
            
            request.setObserveOption(0);
            displayRequest(request);
            clientChannel.sendMessage(request);
         }
      });
      
      
      payload_label.setBounds(20, 570, 350, 30);
      payload_text.setBounds(20, 600, 440, 30);
      payload_text.setFont(new Font("arian", Font.BOLD, 15));
      
      path_label.setBounds(20, 500, 350, 30);
      path_text.setBounds(20, 530, 440, 30);
      path_text.setFont(new Font("arian", Font.BOLD, 15));
      
      display_label.setBounds(20, 10, 100, 20);
      display_text.setLineWrap(true);
      display_text.setFont(new Font("arian", Font.BOLD, 15));
      display_text_jp.setBounds(20, 40, 740, 430);
      
            
      this.add(btn_get);
      this.add(btn_put);
      this.add(btn_observe);
      this.add(path_text);
      this.add(path_label);
      this.add(payload_label);
      this.add(payload_text);
      this.add(display_text_jp);
      this.add(display_label);

     
      this.setSize(800, 800);

    
      this.setVisible(true);

      
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   @Override
   public void onConnectionFailed(CoapClientChannel channel, boolean notReachable, boolean resetByServer) {
      System.out.println("Connection Failed");
      System.exit(-1);
   }

   @Override
   public void onResponse(CoapClientChannel channel, CoapResponse response) {
      if (response.getPayload() != null) {
         display_text.append(
               "Response: " + response.toString() + " payload: " + Encoder.ByteToString(response.getPayload()));
         display_text.setCaretPosition(display_text.getDocument().getLength());  
      } else {
         display_text.append("Response: " + response.toString());
         display_text.setCaretPosition(display_text.getDocument().getLength());
      }
      if (GUI_Client.exitAfterResponse) {
         display_text.append("===END===");
         System.exit(0);
      }
      display_text.append(System.lineSeparator());
      display_text.append("*");
      display_text.append(System.lineSeparator());
      
      
      
      //옵저버의 응답인지 확인한다.
      if(Encoder.ByteToString(response.getToken()).equals("obToken")) {
    	  float temp = Float.parseFloat(Encoder.ByteToString(response.getPayload()));
    	//temp값에 따라서 led resource에 대한 PUT 요청메세지 전송
    	//temp값이 화재 발생 시 온도(화재 상황까지 극한으로 온도를 올릴 수 없으니 30도)에 도달했을 때 
    	  this.control(temp); //컨트롤 메소드
    	  
      }
   }
   //---------------------
   public void control(float temp) {
	   CoapRequest led = clientChannel.createRequest(CoapRequestCode.PUT,"/led",true); //led
	   CoapRequest lcd = clientChannel.createRequest(CoapRequestCode.PUT,"/lcd",true); //lcd
	   CoapRequest buz = clientChannel.createRequest(CoapRequestCode.PUT, "/buzzer", true); //buzzer
	   if(temp>=30.0) {
		   led.setPayload(new CoapData("red",CoapMediaType.text_plain));//화재 발생 시 붉은색
		   lcd.setPayload(new CoapData("A fire broke out.",CoapMediaType.text_plain)); // 화재 발생, 
		   buz.setPayload(new CoapData("on", CoapMediaType.text_plain)); //경보 울림
	   } 
	   else { 
		   led.setPayload(new CoapData("green",CoapMediaType.text_plain));////안전 상태일 때 녹색
		   lcd.setPayload(new CoapData("It's safe now~~~~",CoapMediaType.text_plain)); // 화재 발생, 
		   buz.setPayload(new CoapData("off", CoapMediaType.text_plain)); //경보 꺼짐
		   } 
	   
	   displayRequest(led);
	   displayRequest(lcd);
	   displayRequest(buz);
	   
	   clientChannel.sendMessage(led);
	   clientChannel.sendMessage(lcd);
	   clientChannel.sendMessage(buz);
   }
 //---------------------
	  
   @Override
   public void onMCResponse(CoapClientChannel channel, CoapResponse response, InetAddress srcAddress, int srcPort) {
      // TODO Auto-generated method stub
   }
   
	private void displayRequest(CoapRequest request){
		String temp = Encoder.ByteToString(request.getPayload());
		if(request.getPayload() != null){
			if(temp.equals("red")) {
			display_text.append("화재가 의심되는 상황입니다. 화재 상황인지 식별하고, 조치를 취하십시오");
			display_text.setCaretPosition(display_text.getDocument().getLength());  
		} 
			
		}
		else{
		
			display_text.append("안전한 상태입니다." );
			display_text.setCaretPosition(display_text.getDocument().getLength()); 
		}
	
		display_text.append(System.lineSeparator());
		display_text.append("*");
		display_text.append(System.lineSeparator());
	}
   

   public static void main(String[] args){
      //           
      GUI_Client gui = new GUI_Client("fe80::8c65:e93b:f329:1f9a", CoapConstants.COAP_DEFAULT_PORT);
   }
   
   
}