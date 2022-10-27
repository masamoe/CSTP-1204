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
        if (tags == null) {
            throw new IllegalArgumentException();
        }
        queue = new LinkedList<HtmlTag>();
        Queue<HtmlTag> TempQueue = new LinkedList<HtmlTag>();
        for (HtmlTag tag : tags) {
            TempQueue.add(tag);
        }
        for (HtmlTag tag : TempQueue) {
            queue.add(tag);
        }
    }

    public void addTag(HtmlTag tag) {
        if (tag == null) {
            throw new IllegalArgumentException();
        }
        queue.add(tag);
    }

    public Queue<HtmlTag> getTags() {
        Queue<HtmlTag> result = new LinkedList<HtmlTag>();
        Queue<HtmlTag> TempQueue = new LinkedList<HtmlTag>();
        for (HtmlTag tag : queue) {
            TempQueue.add(tag);
        }
        for (HtmlTag tag : TempQueue) {
            result.add(tag);
        }
        return result;
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
                    System.out.println("Extra closing tag: " + tag);
                } else {
                    HtmlTag top = stack.pop();
                    if (!top.getElement().equals(tag.getElement())) {
                        System.out.println("Mismatched tags: " + top + " and " + tag);
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            System.out.println("Missing closing tag: " + stack.pop());
        }
    }
}
