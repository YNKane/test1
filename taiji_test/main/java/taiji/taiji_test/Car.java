package taiji.taiji_test;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import cn.com.taiji.LicensePlate;

@Entity
public class Car {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id", nullable = false)
	    private int id;
	    @Column(name = "manufacturer", nullable = true, length = 20)
	    private String manufacturer;
	    @Column(name = "color", nullable = true, length = 10)
	    private String color;
	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "licensePlate_id", referencedColumnName = "id")
	    private LicensePlate licensePlateID;

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getManufacturer() {
	        return manufacturer;
	    }

	    public void setManufacturer(String manufacturer) {
	        this.manufacturer = manufacturer;
	    }

	    public String getColor() {
	        return color;
	    }

	    public void setColor(String color) {
	        this.color = color;
	    }

	    public LicensePlate getLicensePlateID() {
	        return licensePlateID;
	    }

	    public void setLicensePlateID(LicensePlate licensePlateID) {
	        this.licensePlateID = licensePlateID;
	    }

	    @Override
	    public String toString() {
	        return "Car{" +
	                "id=" + id +
	                ", manufacturer='" + manufacturer + '\'' +
	                ", color='" + color + '\'' +
	                ", licensePlate=" + licensePlateID +
	                '}';
	    }
}
