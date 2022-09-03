package edu.senac.aula03;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.UserPrincipal;

/**
 * Classe corrigida para o Java 8
 */
public class Arquivos {
	
	public static void main(String[] args) throws Exception {
		Path path = Paths.get("c:\\windows\\system.ini");
		System.out.println(path.toAbsolutePath());
		System.out.println("exists: " + Files.exists(path));		
		
//		path = Path.of("c:\\windows\\system.ini");
		path = Paths.get("c:\\windows\\system.ini");
		System.out.println(path.toAbsolutePath());
		System.out.println("exists: " + Files.exists(path));
		
//		path = Path.of("c:/windows/system.ini");
		path = Paths.get("c:/windows/system.ini");
		System.out.println(path.toAbsolutePath());
		System.out.println("exists: " + Files.exists(path));
		
//		path = Path.of(new URI("file:///c:/windows/system.ini"));
		path = Paths.get(new URI("file:///c:/windows/system.ini"));
		System.out.println(path.toAbsolutePath());
		System.out.println("exists: " + Files.exists(path));
		
		FileTime fileTime = Files.getLastModifiedTime(path);
		System.out.println("lastModifiedTime: " + fileTime);
		
		UserPrincipal owner = Files.getOwner(path);
		System.out.println("owner: " + owner);
	}

}
