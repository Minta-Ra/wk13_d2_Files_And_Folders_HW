package com.codeclan.example.files_and_folders_hw.models;
import javax.persistence.*;

@Entity
@Table
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "file_name")
    private String file_name;

    @Column(name = "extension")
    private String extension;

    @Column(name = "size")
    private double size;

    @ManyToOne
    @JoinColumn(name = "folder_id", nullable = false)
    // A File should have a folder
    private Folder folder;


    public File(String file_name, String extension, double size, Folder folder) {
        this.file_name = file_name;
        this.extension = extension;
        this.size = size;
        this.folder = folder;
    }

    public File() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }
}
