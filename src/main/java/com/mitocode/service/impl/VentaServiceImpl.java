package com.mitocode.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mitocode.model.DetalleVenta;
import com.mitocode.model.Venta;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IVentaRepo;
import com.mitocode.service.IVentaService;

@Service
public class VentaServiceImpl extends ICRUDImpl<Venta, Integer> implements IVentaService {

	@Autowired
	private IVentaRepo repo;
	
	@Override
	protected IGenericRepo<Venta, Integer> getRepo() {
		return repo;
	}

	@Transactional
	@Override
	public Venta registrarVenta(Venta venta) throws Exception {
		
//		for(DetalleVenta det : venta.getDetalleVenta()) {
//			det.setVenta(venta);
//		}
		venta.getDetalleVenta().forEach(det -> det.setVenta(venta));
		
		repo.save(venta);
		
		return venta;
		
	}
}
