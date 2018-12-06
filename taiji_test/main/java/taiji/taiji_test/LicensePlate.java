package taiji.taiji_test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LicensePlate {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id", nullable = false)
	    private int id;
	    @Column(name = "licensePlateNumber",nullable = true, length = 20)
	    private String licensePlateNumber;

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getLicensePlateNumber() {
	        return licensePlateNumber;
	    }

	    public void setLicensePlateNumber(String licensePlateNumber) {
	        this.licensePlateNumber = licensePlateNumber;
	    }

	    @Override
	    public String toString() {
	        return "LicensePlate{" +
	                "id=" + id +
	                ", licensePlateNumber='" + licensePlateNumber + '\'' +
	                '}';
	    }
}
