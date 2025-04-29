package week5.lessons.serialization.SAX;

import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParserDemo2 {

  public static void main(String[] args) throws Exception {
    SAXParserFactory parserFactor = SAXParserFactory.newInstance();
    SAXParser parser = parserFactor.newSAXParser();
    SAXHandler handler = new SAXHandler();
    parser.parse(ClassLoader.getSystemResourceAsStream("week5/Student.xml"), handler);
  }
}

/**
 * The Handler for SAX Events.
 */
class SAXHandler extends DefaultHandler {

  private List<Student> stdList;
  private Student std = null;
  private String content = null;

  public void startDocument() throws SAXException {
    stdList = new ArrayList<>();
  }

  @Override
  public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
    switch (qName) {
      case "student":
        std = new Student();
        std.id = attributes.getValue("id");
        std.active = attributes.getValue("active");
        break;
    }
  }

  @Override
  public void endElement(String uri, String localName, String qName) throws SAXException {
    switch (qName) {
      case "student":
        stdList.add(std);
        break;
      case "firstName":
        std.firstName = content;
        break;
      case "lastName":
        std.lastName = content;
        break;
      case "location":
        std.location = content;
        break;
    }
  }

  @Override
  public void characters(char[] ch, int start, int length) throws SAXException {
    content = String.copyValueOf(ch, start, length).trim();
    System.out.println(content);
  }

  public void endDocument() throws SAXException {
    for (Student std : stdList) {
      System.out.println(std);
    }
  }
}

class Student {

  String id;
  String active;
  String firstName;
  String lastName;
  String location;

  @Override
  public String toString() {
    return firstName + " " + lastName + "(" + id + ")" + location + " Active: " + active;
  }
}
