import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.module.ModuleDescriptor.Provides;
import structures.AssociativeArray;
import structures.KeyNotFoundException;
import java.util.Scanner;

public class AACMappings {

  // fields

  // contains information about the current category
  AACCategory category;

  // Top level category
  AACCategory topLevel;

  // food etc maping thing
  AssociativeArray<String, AACCategory> categories;
  // constructors

  public AACMappings(AACCategory category) {
    this.category = category;
  }

  public AACMappings(String filename) {
    this.topLevel = new AACCategory();
    this.category = new AACCategory();
    File file = new File(filename);
    String input = "";
    try {
      Scanner scanner = new Scanner(file);
      input = scanner.nextLine();
      String[] dividedString = input.split(" ");

      while (scanner.hasNextLine()) {
        if (input.charAt(0) == '>') {
          this.topLevel.addItem(dividedString[0], dividedString[1]);
        }

        else if (input.contains(">")) {
          dividedString = input.split("");
          this.category.addItem(dividedString[0], dividedString[1]);
        }
        input = scanner.nextLine();
      }
      scanner.close();
    } catch (FileNotFoundException e) {
    }

    

  }


  /*
   * this.topLevel = new AACCategory (""); this.category = this.topLevel; //this.category.array
   * //filename constructor???? this.topLevel.addItem("img/food/plate.png", "food");
   * this.topLevel.addItem("img/clothing/hanger.png", "clothing");
   * this.topLevel.addItem("img/food/icons8-strawberry-96.png", "strawberry"); this.categories = new
   * AssociativeArray <String, AACCategory> (); AACCategory food = new AACCategory ("food");
   * food.addItem("img/food/icons8-apple-96.png", "apple");
   * food.addItem("img/food/icons8-cookies-96.png", "cookies"); this.categories.set("food", food);
   */


  // methods

  // Adds the mapping to the current category (or the default category if that is the current
  // category)
  public void add(String address, String name) {
    this.category.addItem(address, name);
  }

  // Gets the current category
  public String getCurrentCategory() {
    return this.category.category;
  }

  // Provides an array of all the images in the current category
  public String[] getImageLocs() {
    return this.category.getImages();
  } // getImageLocs()

  // Given the image location selected, it determines the associated text with the image.
  public String getText(String address) {
    String temp = this.category.getText(address); // may be wronggg
    if (this.category == this.topLevel) {
      try {
        this.category = this.categories.get(temp);
      } catch (KeyNotFoundException e) {
        return "";
      }
    }
    return temp;
  }

  // Determines if the image represents a category or text to speak
  public boolean isCategory(String address) {
    return (address == category.getCategory()); // if input is the same as current category then its
                                                // a category
  }

  // Resets the current category of the AAC back to the default category
  public void reset() {
    this.category = this.topLevel;
  }

  // Writes the ACC mappings stored to a file.
  public void writeToFile(String filename) {
    try {
      PrintWriter pen = new PrintWriter(new File(filename));
      // pen write ACC mappings???
      pen.close();
    } catch (Exception e) {
    }

  }

}

