package academy.digitallab.store.shopping.service;

import java.util.List;

import academy.digitallab.store.shopping.entity.Invoice;

public interface InvoiceService {

	public List<Invoice> findInvoiceAll();

	public Invoice createInvoice(Invoice invoice);

	public Invoice updateInvoice(Invoice invoice);

	public Invoice deleteInvoice(Invoice invoice);

	public Invoice getInvoice(Long id);
}
