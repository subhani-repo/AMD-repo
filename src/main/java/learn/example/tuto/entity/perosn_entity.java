package learn.example.tuto.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.context.annotation.Description;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "perosnEntity")
public class perosn_entity implements Serializable{
    @Id
    @GeneratedValue
	private int pid;
	private String pname;
	private double psal;
	private Date date;
	@Column(columnDefinition = "boolean default false")
	private boolean isdeteled;
//	@Pattern(regexp ="^[A_Z]{5}[1-9]{4}$")
	private String email;
	
}
