package com.serdar.ceran;

import com.serdar.ceran.model.ScriptHolder;
import com.serdar.ceran.model.ScriptPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class ScriptProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScriptProviderApplication.class, args);
	}

	@Component
	private class RunNow implements CommandLineRunner {
		@Autowired
		private ScriptPackageRepository scriptPackageRepository;

		@Override
		public void run(String... strings) throws Exception {
			scriptPackageRepository.deleteAll();

			/* ===================  PACKET 1 ======================*/
			ScriptHolder scriptA = new ScriptHolder();
			scriptA.name = "scriptA";
			scriptA.content = "function scriptA() { return 'some A(1) values'; }";
			ScriptHolder scriptB = new ScriptHolder();
			scriptB.name = "scriptB";
			scriptB.content = "function scriptB() { return 'some B(1) values'; }";

			ScriptPackage item1 = new ScriptPackage();
			item1.mhVersion = "MH_1";
			item1.version = 1L;
			item1.scripts = Stream.of(scriptA, scriptB).collect(Collectors.toSet());
			scriptPackageRepository.save(item1);

			/* ===================  PACKET 2 ======================*/
			scriptA.content = "function scriptA() { return 'some A(2) values' }";
			scriptB.content = "function scriptB() { return 'some B(2) values and uses A script here.' }";
			scriptB.imports = Stream.of(scriptA).collect(Collectors.toSet());

			ScriptPackage item2 = new ScriptPackage();
			item2.mhVersion = "MH_2";
			item2.version = 2L;
			item2.scripts = Stream.of(scriptA, scriptB).collect(Collectors.toSet());
			scriptPackageRepository.save(item2);

			/* ===================  PACKET 3 ======================*/
			ScriptHolder scriptC = new ScriptHolder();
			scriptC.name = "scriptC";
			scriptC.content = "function scriptC() { return 'some C(3) values' }";

			scriptB.content = "function scriptB() { return 'new B(3) values and uses A and C script here.' }";
			scriptB.imports = Stream.of(scriptA, scriptC).collect(Collectors.toSet());

			ScriptPackage item3 = new ScriptPackage();
			item3.version = 3L;
			item3.mhVersion = "MH_3";
			item3.scripts = Stream.of(scriptB, scriptC).collect(Collectors.toSet());
			scriptPackageRepository.save(item3);
		}
	}
}
