package com.marketplaceautopartes.marketplaceapi.service.Impl;
import com.marketplaceautopartes.marketplaceapi.model.Archivo;
import com.marketplaceautopartes.marketplaceapi.model.Lote;
import com.marketplaceautopartes.marketplaceapi.repository.IArchivoRepository;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.repository.ILoteRepository;
import com.marketplaceautopartes.marketplaceapi.service.IArchivoService;
import com.marketplaceautopartes.marketplaceapi.service.ILoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoteServiceImpl extends CRUDImpl<Lote, Integer> implements ILoteService {
  private final ILoteRepository loteRepository;

  @Override
  protected IGenericRepo<Lote, Integer> getRepo() {
    return loteRepository;
  }
}
