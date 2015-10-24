package com.tgbotlibrary.behavior.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.google.common.collect.Lists;
import com.tgbotlibrary.behavior.Behavior;

public interface FileBehavior extends Behavior {

	default List<File> getFiles(String path, String[] extensions) {

		
		/*
		 * final File folder = new File(path); final List<File> filesToReturn =
		 * Lists.newArrayList();
		 * 
		 * for (String string : extensions) {
		 * 
		 * final String fileNameRegex = ""; final Pattern pattern =
		 * Pattern.compile(fileNameRegex);
		 * 
		 * File[] files = folder.listFiles(new FileFilter() {
		 * 
		 * @Override public boolean accept(File pathname) { return
		 * pattern.matcher(pathname.getName()).matches(); } });
		 * 
		 * if (files != null) { filesToReturn.addAll(Lists.newArrayList(files));
		 * }
		 * 
		 * }
		 */
		return null;

	};

	default List<String> getFilesName(String path, String[] extensions) {

		final List<String> files = Lists.newArrayList();

		for (String extension : extensions) {
			try {
				Files.walk(Paths.get(path)).forEach(filePath -> {
					if (Files.isRegularFile(filePath)) {
						String _filepath = filePath.toString();
						if (_filepath.toLowerCase().endsWith(extension.toLowerCase())) {
							files.add(_filepath);
						}
					}
				});
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return files;

	}

	default File getFile(String filename) {
		return new File(filename);
	}

}
