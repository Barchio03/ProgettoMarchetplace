package unicam.IdSProject.mappers;

import org.mapstruct.Mapper;
import unicam.IdSProject.dtos.SellerDTO;
import unicam.IdSProject.users.Seller;

@Mapper(componentModel = "spring")
public interface SellerMapper {
    Seller toEntityWithAllFields(SellerDTO dto);
    SellerDTO toDtoWithAllFields(Seller product);
}