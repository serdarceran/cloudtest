package com.serdar.ceran;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.serdar.ceran.model.PackageMeta;
import com.serdar.ceran.model.ScriptHolder;
import com.serdar.ceran.model.ScriptPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by serdar on 28.01.2017.
 */
@Component
public class PackagePersister  implements CommandLineRunner {
    @Autowired
    private ScriptPackageRepository scriptPackageRepository;

    @Override
    public void run(String... strings) throws Exception {
        List<ScriptPackage> scriptPackages = new ArrayList<>();
        File packageFiles = new ClassPathResource("static/scripts/packages").getFile();
        Arrays.stream(packageFiles.listFiles()).forEach(p-> {
            Optional<File> metaJsonFile = Arrays.stream(p.listFiles((dir, name) -> name.equals("meta.json"))).findFirst();
            metaJsonFile.ifPresent(f-> {
                try {
                    ObjectMapper jsonMapper = new ObjectMapper();
                    PackageMeta metaJson = jsonMapper.readValue(f, PackageMeta.class);
                    ScriptPackage scriptPackage = new ScriptPackage();
                    scriptPackage.version = metaJson.getVersion();
                    scriptPackage.mhVersionCpp = metaJson.getMhVersionCpp();
                    scriptPackage.mhVersionJava = metaJson.getMhVersionJava();
                    scriptPackage.scripts = new HashSet<>();

                    Arrays.stream(p.listFiles((dir, name) -> name.endsWith(".js"))).forEach(jsFile-> {
                        try {
                            scriptPackage.scripts.add(getScriptHolder(jsFile));
                        } catch (IOException e) { e.printStackTrace(); }
                    });

                    scriptPackages.add(scriptPackage);
                } catch (IOException e) { e.printStackTrace(); }
            });
        });

        scriptPackageRepository.deleteAll();
        scriptPackages.stream().forEach(scriptPackageRepository::save);
    }

    private ScriptHolder getScriptHolder(File jsFile) throws IOException {
        ScriptHolder scriptHolder = new ScriptHolder();
        scriptHolder.name = jsFile.getName();
        scriptHolder.content = Files.readAllLines(jsFile.toPath()).stream().collect(Collectors.joining("\n"));
        scriptHolder.imports = getImports(jsFile);
        return scriptHolder;
    }

    private Set<String> getImports(File jsFile) throws IOException {
        return Files.readAllLines(jsFile.toPath()).stream().filter(line -> line.contains("@import"))
                .map(importLine -> importLine.split("@import")[1].trim()).collect(Collectors.toSet());
    }
}
