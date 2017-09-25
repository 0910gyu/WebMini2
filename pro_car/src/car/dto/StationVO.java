package car.dto;

public class StationVO {
	private int id;
	private String csnm;
	private String addr;
	private String cpnm;
	private String lat;
	private String longi;
	
	public StationVO() {
	}

	public StationVO(int id, String csnm, String addr, String cpnm, String lat, String longi) {
		super();
		this.id = id;
		this.csnm = csnm;
		this.addr = addr;
		this.cpnm = cpnm;
		this.lat = lat;
		this.longi = longi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCsnm() {
		return csnm;
	}

	public void setCsnm(String csnm) {
		this.csnm = csnm;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getCpnm() {
		return cpnm;
	}

	public void setCpnm(String cpnm) {
		this.cpnm = cpnm;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLongi() {
		return longi;
	}

	public void setLongi(String longi) {
		this.longi = longi;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StationVO [id=");
		builder.append(id);
		builder.append(", csnm=");
		builder.append(csnm);
		builder.append(", addr=");
		builder.append(addr);
		builder.append(", cpnm=");
		builder.append(cpnm);
		builder.append(", lat=");
		builder.append(lat);
		builder.append(", longi=");
		builder.append(longi);
		builder.append("]");
		return builder.toString();
	}
	
}
