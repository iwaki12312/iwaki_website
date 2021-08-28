package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "music")
@NamedQueries({
	@NamedQuery(
	        name = "getAllMusics",
	        query = "SELECT m FROM Music AS m order by m.id desc"
	    ) ,
	@NamedQuery(
            name = "getAllMusicCount",
            query = "SELECT COUNT(m) FROM Music AS m"
        ) ,
	@NamedQuery(
            name = "getMusicCount",
            query = "SELECT COUNT(m) FROM Music AS m where m.name like :search"
        ) ,
	@NamedQuery(
            name = "getSrarchMusics",
            query = "SELECT m FROM Music AS m where m.name like :search order by m.id desc"
            )

})
@Entity
public class Music {
	@Id
    @Column(name = "id" ,length = 7)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

	@Column(name = "name", nullable = false, unique = true ,length = 64)
	private String name;

	@Column(name = "filename", nullable = false, unique = true ,length = 64)
	private String filename;

	@Column(name = "bpm", nullable = false ,length = 3)
	private Integer bpm;

	@Column(name = "overview", nullable = false ,length = 100)
	private String overview;

	@Column(name = "tag" ,length = 100)
	private String tag;

	@Column(name = "yobi01" ,length = 30)
	private String yobi01;

	@Column(name = "yobi02" ,length = 30)
	private String yobi02;

	@Column(name = "yobi03" ,length = 30)
	private String yobi03;

	@Column(name = "yobi04" ,length = 30)
	private String yobi04;

	@Column(name = "yobi05" ,length = 30)
	private String yobi05;

	@Column(name = "yobi06" ,length = 30)
	private String yobi06;

	@Column(name = "yobi07" ,length = 30)
	private String yobi07;

	@Column(name = "yobi08" ,length = 30)
	private String yobi08;

	@Column(name = "yobi09" ,length = 30)
	private String yobi09;

	@Column(name = "yobi10" ,length = 30)
	private String yobi10;

	@Column(name = "created_at", nullable = false)
	private Timestamp created_at;

	@Column(name = "updated_at", nullable = false)
	private Timestamp updated_at;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Integer getBpm() {
		return bpm;
	}

	public void setBpm(Integer bpm) {
		this.bpm = bpm;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getYobi01() {
		return yobi01;
	}

	public void setYobi01(String yobi01) {
		this.yobi01 = yobi01;
	}

	public String getYobi02() {
		return yobi02;
	}

	public void setYobi02(String yobi02) {
		this.yobi02 = yobi02;
	}

	public String getYobi03() {
		return yobi03;
	}

	public void setYobi03(String yobi03) {
		this.yobi03 = yobi03;
	}

	public String getYobi04() {
		return yobi04;
	}

	public void setYobi04(String yobi04) {
		this.yobi04 = yobi04;
	}

	public String getYobi05() {
		return yobi05;
	}

	public void setYobi05(String yobi05) {
		this.yobi05 = yobi05;
	}

	public String getYobi06() {
		return yobi06;
	}

	public void setYobi06(String yobi06) {
		this.yobi06 = yobi06;
	}

	public String getYobi07() {
		return yobi07;
	}

	public void setYobi07(String yobi07) {
		this.yobi07 = yobi07;
	}

	public String getYobi08() {
		return yobi08;
	}

	public void setYobi08(String yobi08) {
		this.yobi08 = yobi08;
	}

	public String getYobi09() {
		return yobi09;
	}

	public void setYobi09(String yobi09) {
		this.yobi09 = yobi09;
	}

	public String getYobi10() {
		return yobi10;
	}

	public void setYobi10(String yobi10) {
		this.yobi10 = yobi10;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	public Timestamp getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Timestamp updated_at) {
		this.updated_at = updated_at;
	}

}
