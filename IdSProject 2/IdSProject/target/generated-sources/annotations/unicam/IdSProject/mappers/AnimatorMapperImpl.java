package unicam.IdSProject.mappers;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import unicam.IdSProject.dtos.response.AnimatorDTO;
import unicam.IdSProject.users.Animator;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-27T17:31:14+0200",
    comments = "version: 1.6.3, compiler: javac, environment: Java 24.0.2 (Oracle Corporation)"
)
@Component
public class AnimatorMapperImpl implements AnimatorMapper {

    @Override
    public Animator toEntityWithAllFields(AnimatorDTO dto) {
        if ( dto == null ) {
            return null;
        }

        String name = null;
        String description = null;

        name = dto.getName();
        description = dto.getDescription();

        Animator animator = new Animator( name, description );

        return animator;
    }

    @Override
    public AnimatorDTO toDtoWithAllFields(Animator animator) {
        if ( animator == null ) {
            return null;
        }

        AnimatorDTO animatorDTO = new AnimatorDTO();

        animatorDTO.setName( animator.getName() );
        animatorDTO.setDescription( animator.getDescription() );

        return animatorDTO;
    }
}
