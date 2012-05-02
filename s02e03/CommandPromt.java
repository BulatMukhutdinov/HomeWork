package s02e03;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CommandPromt {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Path path1, path = Paths.get(System.getProperty("user.home"));
		String command = "";
		while (!command.equals("exit")) {
			System.out.println(path + ">");
			command = in.nextLine();
			command = command.toLowerCase();
			if (command.substring(0, 2).equals("cd")) {
				try {
					path1 = Paths.get(command.substring(3));
					if (path1.toRealPath() != null) {
						path = Paths.get(command.substring(3));
					}
				} catch (IOException x) {
					System.out.println("No such directory");
				}

			}
			if (command.equals("ls -d")) {
				DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {
					public boolean accept(Path file) throws IOException {
						try {
							return (Files.isDirectory(file));
						} catch (Exception x) {
							System.err.println(x);
							return false;
						}
					}
				};
				try (DirectoryStream<Path> stream = Files.newDirectoryStream(
						path, filter)) {
					for (Path entry : stream) {
						System.out.println(entry.getFileName());
					}
				} catch (IOException x) {
					System.err.println(x);
				}
			}

			if (command.equals("ls -f")) {
				try (DirectoryStream<Path> stream = Files.newDirectoryStream(
						path, "*.*")) {
					for (Path entry : stream) {
						System.out.println(entry.getFileName());
					}
				} catch (IOException x) {

					System.err.println(x);
				}
			}
			if (command.equals("help")) {
				System.out
						.println("cd         смена директории \nls         список всех имеющихся файлов в данной директории, включая папки \nls -f      список имеющихся файлов \nls -d      список имеющихся пакпок в данной директории\nhelp       список и описание имеющихся команд\nexit       выход из программы");
			}
			if (command.equals("ls")) {
				try (DirectoryStream<Path> stream = Files
						.newDirectoryStream(path)) {
					for (Path file : stream) {

						System.out.println(file.getFileName());

					}
				} catch (Exception x) {
					System.err.println(x);
				}
			}

		}
	}

}