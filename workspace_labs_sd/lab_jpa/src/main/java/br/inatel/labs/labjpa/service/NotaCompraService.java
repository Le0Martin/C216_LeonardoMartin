package br.inatel.labs.labjpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.inatel.labs.labjpa.entity.NotaCompra;
import br.inatel.labs.labjpa.entity.NotaCompraItem;

@Service
@Transactional
public class NotaCompraService {

	@PersistenceContext
	private EntityManager em;
	
	public NotaCompra salvar(NotaCompra nc) {
		nc = em.merge(nc);
		return nc;
	}
	
	public NotaCompra buscarNotaCompraPeloId(Long id) {
		NotaCompra nc = em.find(NotaCompra.class, id);
		return nc;
	}
	
	public List<NotaCompra> listarNotaCompra() {
		List<NotaCompra> notas = em.createQuery("select n from nota compra n", NotaCompra.class).getResultList();
		return notas;
	}
	
	
	public NotaCompraItem salvarNotaCompraItem(NotaCompraItem item) {
		item = em.merge(item);
		return item;
	}
	
	public NotaCompraItem buscarNotaCompraItemPeloId(Long id) {
		NotaCompraItem item = em.find(NotaCompraItem.class, id);
		return item;
	}
	
    public List<NotaCompraItem> listarNotaCompraItem(){
        return em.createQuery("select i from NotaCompraItem i", NotaCompraItem.class).getResultList();
    }
}
