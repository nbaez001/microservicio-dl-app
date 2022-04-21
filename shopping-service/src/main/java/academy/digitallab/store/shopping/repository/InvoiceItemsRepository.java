package academy.digitallab.store.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import academy.digitallab.store.shopping.entity.InvoiceItem;

public interface InvoiceItemsRepository extends JpaRepository<InvoiceItem, Long> {
	
}
