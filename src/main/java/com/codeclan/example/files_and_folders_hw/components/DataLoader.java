package com.codeclan.example.files_and_folders_hw.components;
import com.codeclan.example.files_and_folders_hw.models.File;
import com.codeclan.example.files_and_folders_hw.models.Folder;
import com.codeclan.example.files_and_folders_hw.models.User;
import com.codeclan.example.files_and_folders_hw.repositories.FileRepository;
import com.codeclan.example.files_and_folders_hw.repositories.FolderRepository;
import com.codeclan.example.files_and_folders_hw.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    UserRepository userRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args) {

        User user1 = new User("Anna");
        userRepository.save(user1);

        Folder folder1 = new Folder("Codeclan_week13", user1);
        folderRepository.save(folder1);

        Folder folder2 = new Folder("Codeclan_week14", user1);
        folderRepository.save(folder2);

        Folder folder3 = new Folder("Codeclan_week15", user1);
        folderRepository.save(folder3);

        File file1 = new File("homework", ".zip", 12.3, folder1);
        fileRepository.save(file1);

        File file2 = new File("class_notes_week13_day2", ".txt", 0.8, folder1);
        fileRepository.save(file2);

        File file3 = new File("class_notes_week13_day3", ".txt", 1.5, folder1);
        fileRepository.save(file3);

        File file4 = new File("class_notes", ".txt", 2.1, folder2);
        fileRepository.save(file4);

        File file5 = new File("week14_homework", ".md", 1.7, folder2);
        fileRepository.save(file5);

        File file6 = new File("hotel_lab", ".md", 0.9, folder3);
        fileRepository.save(file6);

        File file7 = new File("hotel_lab_start_code", ".zip", 2.4, folder3);
        fileRepository.save(file7);


        // Add files to folders
        folder1.addFile(file1);
        folder1.addFile(file2);
        folder1.addFile(file3);
        folderRepository.save(folder1);

        // Add folders to users
        user1.addFolder(folder1);
        user1.addFolder(folder2);
        user1.addFolder(folder3);
        userRepository.save(user1);
    }

}
