package com.example.Athos.converter;

public interface Converter<Entity,DTO> {

	public Entity converToEntity(DTO dto);
	
	public DTO covertToDTO(Entity entity);
	
}
