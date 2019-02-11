package com.example.Athos.converter;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.example.Athos.dto.SponsorDTO;
import com.example.Athos.model.Sponsor;

@Component
public class SponsorConverter implements Converter<Sponsor , SponsorDTO>{
	
	@Override
	public Sponsor converToEntity(SponsorDTO sponsordto) {
		
		Sponsor sponsor=new Sponsor();
		
		sponsor.setId(sponsordto.getId());
		sponsor.setName(sponsordto.getName());
		sponsor.setAttivo(sponsordto.isAttivo());
		sponsor.setMessaggio(sponsordto.getMessaggio());
		
		return sponsor;
	}
	
//	public static List <Sponsor> toEntityList(List<SponsorDTO> sponsorListDTO){
//		List<Sponsor> sponsorList = new ArrayList<>();
//		for(SponsorDTO sponsorDTO : sponsorListDTO)
//			sponsorList.add(SponsorConverter.converToEntity(sponsorDTO));
//		return sponsorList;		
//	}
//	public static List <SponsorDTO> toDTOList(List<Sponsor> sponsorList){
//		List<SponsorDTO> sponsorDTOList = new ArrayList<>();
//		for(Sponsor sponsor : sponsorList)
//			sponsorDTOList.add(SponsorConverter.convertToDTO(sponsor));
//		return sponsorDTOList;
//	}
	
	@Override
	public  SponsorDTO convertToDTO(Sponsor sponsor) {
		
		SponsorDTO sponsorDTO=new SponsorDTO();
		
		sponsorDTO.setId(sponsor.getId());
		sponsorDTO.setName(sponsor.getName());
		sponsorDTO.setAttivo(sponsor.isAttivo());
		sponsorDTO.setMessaggio(sponsor.getMessaggio());
		
		return sponsorDTO;
		}
}
