package com.example.Athos.converter;

import org.springframework.stereotype.Component;
import com.example.Athos.dto.EventoDTO;
import com.example.Athos.model.Evento;
	

	@Component
	public class EventoConverter implements Converter<Evento , EventoDTO>{
		
		@Override
		public  Evento converToEntity(EventoDTO eventoDTO) {
			
			Evento evento=new Evento();
			
			evento.setId(eventoDTO.getId());
			evento.setId_game(eventoDTO.getId_game());
			evento.setDescr_evento(eventoDTO.getDescr_evento());
			evento.setData_inizio(eventoDTO.getData_inizio());
			evento.setData_fine(eventoDTO.getData_fine());
			return evento;
		}

		@Override
		public  EventoDTO convertToDTO(Evento evento) {
			
			EventoDTO eventoDTO=new EventoDTO();
			
			eventoDTO.setId(evento.getId());
			eventoDTO.setId_game(evento.getId_game());
			eventoDTO.setDescr_evento(evento.getDescr_evento());
			eventoDTO.setData_inizio(evento.getData_inizio());
			eventoDTO.setData_fine(evento.getData_fine());
				
			return eventoDTO;
			
			}
	}

