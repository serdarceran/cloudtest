package com.serdar.ceran;

import com.serdar.ceran.model.ScriptPackage;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by serdar on 27.01.2017.
 */
public interface ScriptPackageRepository extends MongoRepository<ScriptPackage, String>  {
    ScriptPackage findFirstByMhVersion(String mhVersion);
//    ScriptPackage findFirstByScriptsNameInAndMhVersionOrderByVersionDesc(String scriptName,String mhVersion);
    ScriptPackage findFirstByVersionLessThanOrderByVersionDesc(long version);
}
