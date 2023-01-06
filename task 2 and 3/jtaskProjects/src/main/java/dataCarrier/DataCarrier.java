package dataCarrier;

import java.util.HashMap;
import java.util.Map;

public class DataCarrier {

	private Map<DataCarrierEnum, Object> map = new HashMap<DataCarrierEnum, Object>();

	public Map<DataCarrierEnum, Object> getMap() {
		return map;
	}

	public void setMap(Map<DataCarrierEnum, Object> map) {
		this.map = map;
	}

	public Object getValue(DataCarrierEnum key) {
		return map.get(key);
	}

	public void put(DataCarrierEnum key, Object value) {
		map.put(key, value);
	}

}
