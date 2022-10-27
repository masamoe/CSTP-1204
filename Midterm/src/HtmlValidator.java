import java.util.*;

/*
 * This is the HtmlValidator class.
 * You should implement this class.
 */
public class HtmlValidator {
    private Stack<HtmlTag> stack;
    private Queue<HtmlTag> queue;

    public HtmlValidator() {
        queue = new LinkedList<HtmlTag>();
    }

    public HtmlValidator(Queue<HtmlTag> tags) {
        queue = new LinkedList<HtmlTag>();
    }

    public void addTag(HtmlTag tag) {
        queue.add(tag);
    }

    public Queue<HtmlTag> getTags() {
        return queue;
    }

    public void removeAll(String element) {
        for (HtmlTag tag : queue) {
            if (tag.getElement().equals(element)) {
                queue.remove(tag);
            }
        }
    }

    public void validate() {
        stack = new Stack<HtmlTag>();
        for (HtmlTag tag : queue) {
            if (tag.isOpenTag()) {
                stack.push(tag);
            } else {
                if (stack.isEmpty()) {
                    System.out.println("Error: " + tag.getElement() + " tag is not opened");
                } else {
                    HtmlTag top = stack.pop();
                    if (!top.getElement().equals(tag.getElement())) {
                        System.out.println("Error: " + tag.getElement() + " tag is not opened");
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            HtmlTag top = stack.pop();
            System.out.println("Error: " + top.getElement() + " tag is not closed");
        }
    }
}
