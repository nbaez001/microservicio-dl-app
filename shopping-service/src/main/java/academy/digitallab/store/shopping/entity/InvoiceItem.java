package academy.digitallab.store.shopping.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Data
@Table(name = "tbl_invoce_items")
public class InvoiceItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Positive(message = "El stock debe ser mayor que cero")
	private Double quantity;
	private Double price;

	@Column(name = "product_id")
	private Long productId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "invoice_id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Invoice invoice;

	@Transient
	private Double subTotal;

	public Double getSubTotal() {
		if (this.price > 0 && this.quantity > 0) {
			return this.quantity * this.price;
		} else {
			return (double) 0;
		}
	}

	public InvoiceItem() {
		this.quantity = (double) 0;
		this.price = (double) 0;

	}
}
