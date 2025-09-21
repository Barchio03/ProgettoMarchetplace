package unicam.IdSProject.mappers;

import org.mapstruct.Mapper;
import unicam.IdSProject.dtos.BuyerDTO;
import unicam.IdSProject.users.Buyer;

@Mapper(componentModel = "spring")
public interface BuyerMapper {
    Buyer toEntityWithAllFields(BuyerDTO dto);
    BuyerDTO toDtoWithAllFields(Buyer product);
}