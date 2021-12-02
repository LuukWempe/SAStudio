package com.stedin.HighVoltage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="iedsignals")
public class IEDSignal{
	
	@Id
	@GeneratedValue
	private Long iedSignalId;
	
	@ManyToOne
	@JoinColumn(name="ied_id", nullable=false)
	private IED ied;
	
	@Column(name="name")
	private String name;
	
	@Column(name="instation")
	private boolean fp_inStation;
	
	@Column(name="numdiai")
	private int fp_NumDiAi;
	
	@Column(name="numdu")
	private int fp_NumDu;
	
	@Column(name="vertraging")
	private String fp_Vertraging;
	
	@Column(name="hwsw")
	private String fp_HwSw; 
	
	@Column(name="iedslot")
	private String fp_IedSlot;
	
	@Column(name="klem")
	private String fp_Klem; 
	
	@Column(name="iedio1")
	private String fp_IedIO1;
	
	@Column(name="iedio1pos")
	private int fp_IedIO1Pos;
	
	@Column(name="iedio1neg")
	private int fp_IedIO1Neg;
	
	@Column(name="iedio2")
	private String fp_IedIO2;
	
	@Column(name="iedio2pos")
	private int fp_IedIO2Pos;

	@Column(name="iedio2neg")
	private int fp_IedIO2Neg;
	
	@Column(name="iedio3")
	private String fp_IedIO3;
	
	@Column(name="iedio3pos")
	private int fp_IedIO3Pos;

	@Column(name="iedio3neg")
	private int fp_IedIO3Neg;
	
	@Column(name="iedio4")
	private String fp_IedIO4;
	
	@Column(name="iedio4pos")
	private int fp_IedIO4Pos;

	@Column(name="iedio4neg")
	private int fp_IedIO4Neg;
	
	@Column(name="normalepositie")
	private boolean fp_NormalePositie;
	
	@Column(name="inverteren")
	private boolean fp_Inverteren;
	
	
	public IEDSignal() {}
	
	
	public IEDSignal(long iedSignalId, IED ied, String name, boolean fp_inStation, int fp_NumDiAi, int fp_NumDu,
			String fp_Vertraging, String fp_HwSw, String fp_IedSlot, String fp_Klem, String fp_IedIO1, int fp_IedIO1Pos,
			int fp_IedIO1Neg, String fp_IedIO2, int fp_IedIO2Pos, int fp_IedIO2Neg, String fp_IedIO3, int fp_IedIO3Pos,
			int fp_IedIO3Neg, String fp_IedIO4, int fp_IedIO4Pos, int fp_IedIO4Neg, boolean fp_NormalePositie,
			boolean fp_Inverteren) {
		this.iedSignalId = iedSignalId;
		this.ied = ied;
		this.name = name;
		this.fp_inStation = fp_inStation;
		this.fp_NumDiAi = fp_NumDiAi;
		this.fp_NumDu = fp_NumDu;
		this.fp_Vertraging = fp_Vertraging;
		this.fp_HwSw = fp_HwSw;
		this.fp_IedSlot = fp_IedSlot;
		this.fp_Klem = fp_Klem;
		this.fp_IedIO1 = fp_IedIO1;
		this.fp_IedIO1Pos = fp_IedIO1Pos;
		this.fp_IedIO1Neg = fp_IedIO1Neg;
		this.fp_IedIO2 = fp_IedIO2;
		this.fp_IedIO2Pos = fp_IedIO2Pos;
		this.fp_IedIO2Neg = fp_IedIO2Neg;
		this.fp_IedIO3 = fp_IedIO3;
		this.fp_IedIO3Pos = fp_IedIO3Pos;
		this.fp_IedIO3Neg = fp_IedIO3Neg;
		this.fp_IedIO4 = fp_IedIO4;
		this.fp_IedIO4Pos = fp_IedIO4Pos;
		this.fp_IedIO4Neg = fp_IedIO4Neg;
		this.fp_NormalePositie = fp_NormalePositie;
		this.fp_Inverteren = fp_Inverteren;
	}


	public Long getSignalID() {return iedSignalId;}
	public void setSignalID(Long id) {this.iedSignalId = id;}
	
	public String getSignalName() {return name;}
	public void setSignalName(String name) {this.name = name;}
	
	public IED getIEDID() {return ied;}
	public void setIEDID(IED ied) {this.ied = ied;}
	
}