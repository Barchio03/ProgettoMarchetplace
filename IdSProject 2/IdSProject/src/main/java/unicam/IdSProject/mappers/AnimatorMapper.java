package unicam.IdSProject.mappers;

import org.mapstruct.Mapper;
import unicam.IdSProject.dtos.response.AnimatorDTO;
import unicam.IdSProject.users.Animator;

@Mapper(componentModel = "spring")
public interface AnimatorMapper {
    Animator toEntityWithAllFields(AnimatorDTO dto);
    AnimatorDTO toDtoWithAllFields(Animator animator);
}
