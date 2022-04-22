package academy.digitallab.store.shopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academy.digitallab.store.shopping.entity.Invoice;
import academy.digitallab.store.shopping.entity.InvoiceItem;
import academy.digitallab.store.shopping.repository.InvoiceItemsRepository;
import academy.digitallab.store.shopping.repository.InvoiceRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	InvoiceRepository invoiceRepository;

	@Autowired
	InvoiceItemsRepository invoiceItemsRepository;

	@Override
	public List<Invoice> findInvoiceAll() {
		List<Invoice> lInvoice = invoiceRepository.findAll();
		for (Invoice in : lInvoice) {
			List<InvoiceItem> lInvoiceDet = invoiceItemsRepository.findByInvoiceId(in.getId());
			in.setItems(lInvoiceDet);
		}
		return lInvoice;
	}

	@Override
	public Invoice createInvoice(Invoice invoice) {
		Invoice invoiceDB = invoiceRepository.findByNumberInvoice(invoice.getNumberInvoice());
		if (invoiceDB != null) {
			return invoiceDB;
		}
		invoice.setState("CREATED");

		Invoice invoiceReg = invoiceRepository.save(invoice);
		for (InvoiceItem item : invoice.getItems()) {
			item.setInvoiceId(invoiceReg.getId());
			invoiceItemsRepository.save(item);
		}
		return invoice;
	}

	@Override
	public Invoice updateInvoice(Invoice invoice) {
		Invoice invoiceDB = getInvoice(invoice.getId());
		if (invoiceDB == null) {
			return null;
		}
		invoiceDB.setCustomerId(invoice.getCustomerId());
		invoiceDB.setDescription(invoice.getDescription());
		invoiceDB.setNumberInvoice(invoice.getNumberInvoice());
		invoiceDB.getItems().clear();
		invoiceDB.setItems(invoice.getItems());
		return invoiceRepository.save(invoiceDB);
	}

	@Override
	public Invoice deleteInvoice(Invoice invoice) {
		Invoice invoiceDB = getInvoice(invoice.getId());
		if (invoiceDB == null) {
			return null;
		}
		invoiceDB.setState("DELETED");
		return invoiceRepository.save(invoiceDB);
	}

	@Override
	public Invoice getInvoice(Long id) {
		return invoiceRepository.findById(id).orElse(null);
	}
}
