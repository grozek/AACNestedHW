import structures.AssociativeArray;
import structures.KeyNotFoundException;


//
public class AACCategory {

  // fields
  AssociativeArray<String, String> array;
  String category;

  // constructors
  public AACCategory(String category) {
    this.category = category;
    this.array = new AssociativeArray<String, String>();
  }

    public AACCategory() {
    this.array = new AssociativeArray<String, String>();
  }

  // methods
  // Adds the mapping of the imageLoc to the text to the category.
  public void addItem(String address, String name) {
    this.array.set(address, name);
  } // getImageLocs()

  // Returns the name of the category
  public String getCategory() {
    return this.category;
  }

  public String[] getImages(){
    return this.array.allKeys();
  }
  // Returns an array of all the images in the category
  /*public String[] getImages() {
    String[] newStrAr = new String[20]; // 20 is justa random limit
    int i = 0;

    while (array.hasKey(category)) {
      try {
        newStrAr[i] = this.array.get(category);
      } catch (KeyNotFoundException e) {
        return newStrAr;
      }
      i++;
    }
*/
    //return newStrAr;
    // return new String[] {"img/food/icons8-french-fries-96.png",
    // "img/food/icons8-watermelon-96.png"};
  

  // Returns the text associated with the given image loc in this category
  public String getText(String address) {
    String temp;
    try {
      temp = this.array.get(address);
    } catch (KeyNotFoundException e) {
      return "";
    }
    return temp;
  }

  // Determines if the provided images is stored in the category
  public boolean hasImage() {
    return array.hasKey(this.category);
  }

}
