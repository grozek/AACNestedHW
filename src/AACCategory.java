/**
 * CSC-207 Mini-project-5 Gabriela Roznawska 12-10-2023 Acknowledgements: Profesor Rebelsky and all
 * of his online resources, Class mentors: Micah and Pom, Java documentation
 * 
 * This project is based on AssociativeArray that maps image locations to words
 */

import structures.AssociativeArray;
import structures.KeyNotFoundException;


public class AACCategory {

  /**
   * Fields
   */
  AssociativeArray<String, String> array;
  String category;

  /**
   * Single string input constructor of AACCategory
   */
  public AACCategory(String category) {
    this.category = category;
    this.array = new AssociativeArray<String, String>();
  } // AACCategory(String)

  /**
   * A no-input AACCategory constructor
   */
  public AACCategory() {
    this.category = "";
    this.array = new AssociativeArray<String, String>();
  } // AACCAtegory()

  /**
   * Methods
   */

  /**
   * Adds the mapping of the imageLoc to the text to the category.
   */
  public void addItem(String address, String name) {
    this.array.set(address, name);
  } // addItem(String, String)

  /**
   * Returns the name of the category
   */
  public String getCategory() {
    return this.category;
  } // getCategory()

  /**
   * Returns an array of all the images in the category
   */
  public String[] getImages() {
    return this.array.allKeys();
  } // getImages()


  /**
   * Returns the text associated with the given image loc in this category
   */
  public String getText(String address) {
    String temp;
    try {
      temp = this.array.get(address);
    } catch (KeyNotFoundException e) {
      return "";
    } // catch
    return temp;
  } // getText(String)

  /**
   * Determines if the provided images is stored in the category
   */
  public boolean hasImage() {
    return array.hasKey(this.category);
  } // ahsImage()
} // AACCategory class
