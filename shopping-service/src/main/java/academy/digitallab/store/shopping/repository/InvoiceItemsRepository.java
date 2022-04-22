package academy.digitallab.store.shopping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import academy.digitallab.store.shopping.entity.InvoiceItem;

public interface InvoiceItemsRepository extends JpaRepository<InvoiceItem, Long> {
	
	public List<InvoiceItem> findByInvoiceId(Long invoiceId);
}
