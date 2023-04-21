package guessBean.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigurationService {
	private final ConfigurationRepository configurationRepository;
	
    @Autowired
    public ConfigurationService(ConfigurationRepository configurationRepository){
        this.configurationRepository = configurationRepository;
    }
    public Configuration addConfiguration(Configuration configuration){
        return configurationRepository.save(configuration);
    }
    public Configuration getConfiguration(String propiedad){
        return configurationRepository.findByPropiedad(propiedad).get(1);
    }
    public List<Configuration> getAllConfiguration(){
        return configurationRepository.findAll();
    }
    public Configuration updateConfiguration(Configuration configuration){
        if(configurationRepository.findByPropiedad(configuration.getPropiedad()).size() == 0){
            return configurationRepository.save(configuration);
        }
        return null;
    }
    public void deleteConfiguration(Long propiedad){
        configurationRepository.deleteById(propiedad);
    }

    public void flush() {
        configurationRepository.flush();
    }

    public String getValorOfPremio() {
        return configurationRepository.findByPropiedad("premio").get(0).getValor();
    }
}
