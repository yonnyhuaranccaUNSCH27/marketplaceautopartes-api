package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Tienda;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.repository.ITiendaRepository;
import com.marketplaceautopartes.marketplaceapi.service.ITiendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TiendaServiceImpl extends CRUDImpl<Tienda,Integer> implements ITiendaService {

    private final ITiendaRepository tiendaRepository;

    @Override
    protected IGenericRepo<Tienda,Integer> getRepo() {return tiendaRepository;}

//  @Transactional
//  public TiendaDTO crearTienda(TiendaDTO tiendaDTO, MultipartFile certificado) throws IOException {
//
//    Tienda tienda = convertirDTOaEntity(tiendaDTO);
//
//    // Procesar archivo de certificado si existe
//    if (certificado != null && !certificado.isEmpty()) {
//      validarCertificado(certificado);
//
//      tienda.setFileCertificado(certificado.getBytes());
//      tienda.setNombreCertificado(certificado.getOriginalFilename());
//      tienda.setTipoCertificado(certificado.getContentType());
//    }
//
//    tienda.setFechaCreacion(LocalDateTime.now());
//    tienda.setEstado(true);
//
//    Tienda tiendaGuardada = tiendaRepository.save(tienda);
//
//    return convertirEntityADTO(tiendaGuardada);
//  }
//
//  @Transactional
//  public TiendaDTO actualizarTienda(Integer id, TiendaDTO tiendaDTO, MultipartFile certificado) throws IOException {
//
//    Tienda tiendaExistente = tiendaRepository.findById(id)
//        .orElseThrow(() -> new RuntimeException("Tienda no encontrada"));
//
//    // Actualizar campos
//    actualizarCampos(tiendaExistente, tiendaDTO);
//
//    // Actualizar certificado solo si se proporciona uno nuevo
//    if (certificado != null && !certificado.isEmpty()) {
//      validarCertificado(certificado);
//
//      tiendaExistente.setFileCertificado(certificado.getBytes());
//      tiendaExistente.setNombreCertificado(certificado.getOriginalFilename());
//      tiendaExistente.setTipoCertificado(certificado.getContentType());
//    }
//
//    tiendaExistente.setFechaModificacion(LocalDate.now());
//
//    Tienda tiendaActualizada = tiendaRepository.save(tiendaExistente);
//
//    return convertirEntityADTO(tiendaActualizada);
//  }
//
//  /**
//   * Valida el archivo de certificado
//   */
//  private void validarCertificado(MultipartFile archivo) {
//    // Validar tamaño (5 MB máximo)
//    long maxSize = 5 * 1024 * 1024; // 5 MB
//    if (archivo.getSize() > maxSize) {
//      throw new RuntimeException("El archivo excede el tamaño máximo de 5 MB");
//    }
//
//    // Validar extensión
//    String nombreArchivo = archivo.getOriginalFilename();
//    if (nombreArchivo == null ||
//        (!nombreArchivo.toLowerCase().endsWith(".pfx") &&
//            !nombreArchivo.toLowerCase().endsWith(".p12"))) {
//      throw new RuntimeException("Solo se permiten archivos .pfx o .p12");
//    }
//  }

}
