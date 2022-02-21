package mutato115.mods.hgmrs.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

import com.google.gson.Gson;

import mutato115.mods.hgmrs.HGMRsMod;
import mutato115.mods.hgmrs.json.Question;
import mutato115.mods.hgmrs.json.Questions;

public class WorldConfigHandler {
	
	
	public static void createFiles(File dir)  {
		
		if (!dir.exists()) {
    		dir.mkdirs();
    	}
		
		File ravenclaw = new File(dir, "ravenclaw.json");
		
		try {
			if (!ravenclaw.exists()) {
				ravenclaw.createNewFile();
			}
			validateFile(ravenclaw);
		} catch (IOException e) {
			HGMRsMod.mod.getLogger().error("Was not able to create the HGMR configuration files in:  \'" + dir.getAbsolutePath() + "\'!" );
		}
		
	}
	
	
	private static void validateFile(File file) {
		
		
		
	}
	
	
	public static Questions getQuestions(File file) {
		try {
			String json = new String(Files.readAllBytes(file.toPath()));
			Gson gson = new Gson();
			Questions questions = gson.fromJson(json, Questions.class);
			
			if (questions != null) {
				return questions;
			} else {
				return new Questions(new ArrayList<Question>());
			}
		} catch (IOException e) {
			HGMRsMod.mod.getLogger().error("Was not able to read the HGMR configuration file:  \'" + file.getAbsolutePath() + "\'!" );
			return null;
		}
	}

	
}
