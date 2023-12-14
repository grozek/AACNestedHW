/**
 * CSC-207 
 * Mini-project-5 
 * Gabriela Roznawska 
 * 12-10-2023 
 * Acknowledgements: Profesor Rebelsky and allof his online resources, 
 * Class mentors: Micah and Pom, Java documentation
 * 
 * This part of the project is AACMappings that contains AACCategory objects
 * taht map filenames to their corresponding words 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.module.ModuleDescriptor.Provides;
import structures.AssociativeArray;
import structures.KeyNotFoundException;
import java.util.Scanner;

public class AACMappings {

/**
 * fields
 */
  // contains information about the current category
  AACCategory category;
  // Top level category
  AACCategory topLevel;
  AssociativeArray<String, AACCategory> categories;
 
  /**
   * 
   * AACMappings constructor with a AACCategory input
   */
  public AACMappings(AACCategory category) {
    this.category = category;
  }

/**
 * AACMappingsconstructor that takes in filename as input
 * it "scans" the file and sources out the topLevel categories
 * as well as the regular categories
 */
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
        if (input.charAt(0) != '>') {
          this.category.addItem(dividedString[0], dividedString[1]);
          // Build the category for this new category
          // Add it to categories
        } // if
        else {
          this.topLevel.addItem(dividedString[0], dividedString[1]);
          this.category = new AACCategory(dividedString[1]);
        } // else
        input = scanner.nextLine();
      } // while
      scanner.close();
    } catch (FileNotFoundException e) {
    } // catch
  } // AACMappings 


  /*
   * this.topLevel = new AACCategory (""); this.category = this.topLevel; //this.category.array
   * //filename constructor???? this.topLevel.addItem("img/food/plate.png", "food");
   * this.topLevel.addItem("img/clothing/hanger.png", "clothing");
   * this.topLevel.addItem("img/food/icons8-strawberry-96.png", "strawberry"); this.categories = new
   * AssociativeArray <String, AACCategory> (); AACCategory food = new AACCategory ("food");
   * food.addItem("img/food/icons8-apple-96.png", "apple");
   * food.addItem("img/food/icons8-cookies-96.png", "cookies"); this.categories.set("food", food);
   */


  /**
   * Methods
   */

  /**
   * Adds the mapping to the current category (or the default category if that is the current
   * category)
   */
  public void add(String address, String name) {
    this.category.addItem(address, name);
  } // add (String, String)

  /**
   * Returns the current category of AACCategory field
   */
  public String getCurrentCategory() {
    return this.category.category;
  } // getCurrentCategory()

  /**
   * Provides an array of all the images in the current category
   */
  public String[] getImageLocs() {
    return this.category.getImages();
  } // getImageLocs()

  /**
   * Given the image location selected, it determines the associated text with the image.
   */
  public String getText(String address) {
    String temp = this.category.getText(address); // may be wronggg
    if (this.category == this.topLevel) {
      try {
        this.category = this.categories.get(temp);
      } catch (KeyNotFoundException e) {
        return "";
      } // catch
    } // if
    return temp;
  } // getText (String)

  /**
   * Determines if the image represents a category or text to speak
   */
  public boolean isCategory(String address) {
    return (address == category.getCategory());
  } // isCategory (String)

  /**
   * Resets the current category of the AAC back to the default category
   */
  public void reset() {
    this.category = this.topLevel;
  } // reset()

  /**
   * Writes the ACC mappings stored to a file.
   */
  public void writeToFile(String filename) {
    try {
      PrintWriter pen = new PrintWriter(new File(filename));
      // pen write ACC mappings???
      pen.close();
    } catch (Exception e) {
    } // catch
  } //writeToFile(String)
}// AACMappings class

