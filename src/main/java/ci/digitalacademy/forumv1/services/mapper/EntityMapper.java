package ci.digitalacademy.forumv1.services.mapper;

public interface EntityMapper<D, E> {
    D fromEntity(E entity);
    E toEntity(D dto);

}
