package in.ashokit.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.ashokit.binding.CitizenApp;
import in.ashokit.entity.CitizenAppEntity;
import in.ashokit.repository.CitizenAppRepository;

@Service
public class ARServiceImpl implements ARService {

	@Autowired
	private CitizenAppRepository appRepo;

	@Override
	public String createApplication(CitizenApp app) {
		
		String endpointUrl =""
		
		RestTemplate rt = new RestTemplate();
		
		ResponseEntity<String> resEntity = rt.getForEntity( endpointUrl, String.class, app.getSsn());
		
		String statename = resEntity.getBody();
		
		if ("Rod Island".equals(statename)) {
			//create application
			
			CitizenAppEntity entity = new CitizenAppEntity();
			BeanUtils.copyProperties(app,entity);
			appRepo.save(entity);
			return true;
		}
		return false;
	}
		
		
	}


