package project;

import java.util.List;

import org.ws4d.coap.core.enumerations.CoapMediaType;
import org.ws4d.coap.core.rest.BasicCoapResource;
import org.ws4d.coap.core.rest.CoapData;
import org.ws4d.coap.core.tools.Encoder;
import week7.DHT11;

public class Temp_Sensor extends BasicCoapResource{

	private String value = "0";
	PJDHT11 dht = new PJDHT11();
	
	private Temp_Sensor(String path, String value, CoapMediaType mediaType) {
		super(path, value, mediaType);
	}

	public Temp_Sensor() {
		this("/temperature", "0", CoapMediaType.text_plain);
	}

	@Override
	public synchronized CoapData get(List<String> query, List<CoapMediaType> mediaTypesAccepted) {
		return get(mediaTypesAccepted);
	}
	
	@Override
	public synchronized CoapData get(List<CoapMediaType> mediaTypesAccepted) {
		float[] sensing_data = dht.getData(15);
		this.value = Float.toString(sensing_data[1]);
		return new CoapData(Encoder.StringToByte(this.value), CoapMediaType.text_plain);
	}

	
	//week13
	public synchronized void optional_changed() {
		// 온도값 읽기
		float[] sensing_data = dht.getData(15);
		String temp = Float.toString(sensing_data[1]);
		
		// 온도값 비교 후, 온도값 변경 시에만 Observe 응답 전송
		if (temp.equals(this.value)) {
			System.out.println("Temperature has not changed.");
		} else if (temp.equals("-99.0")) {
			System.out.println("Temperature Measurement Error");
		} else {
			this.changed(temp);
			this.value = temp;
		}		
	}
	
	
	@Override
	public synchronized boolean setValue(byte[] value) {
		this.value = Encoder.ByteToString(value);
		return true;
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
	public synchronized String getResourceType() {
		return "Raspberry pi 4 Temperature Sensor";
	}
}
