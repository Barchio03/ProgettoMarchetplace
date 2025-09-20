package unicam.IdSProject.mappers;

import org.mapstruct.Mapper;
import unicam.IdSProject.dtos.AnimatorDTO;
import unicam.IdSProject.models.Animator;

@Mapper(componentModel = "spring")
public interface AnimatorMapper {
    Animator toEntityWithAllFields(AnimatorDTO dto);
    AnimatorDTO toDtoWithAllFields(Animator product);
}