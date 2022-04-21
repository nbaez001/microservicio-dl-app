package academy.digitallab.store.shopping.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_invoices")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Invoice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "number_invoice")
	private String numberInvoice;

	private String description;

	@Column(name = "customer_id")
	private Long customerId;

	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;

//	@Valid
//	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
//	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinColumn(name = "invoice_id")
//	private List<InvoiceItem> items;

	@Transient
	private List<InvoiceItem> items;

	private String state;

	@PrePersist
	public void prePersist() {
		this.createAt = new Date();
	}

}
