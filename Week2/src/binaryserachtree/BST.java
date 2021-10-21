package binaryserachtree;

public class BST {
    private Node root = null;

    // 탐색
    public boolean find(int data) {
        Node head = root;

        // leaf node 까지 탐색
        while (head != null) {
            // 데이터가 루트 노드의 값과 같으면 바로 true 리턴
            if (head.getData() == data) {
                return true;
            // 데이터가 루트 노드의 값보다 작으면 왼쪽 서브 트리 탐색
            } else if (head.getData() > data) {
                head = root.getLeft();
            // 데이터가 루트 노드의 값보다 크면 오른쪽 서브 트리 탐색
            } else {
                head = root.getRight();
            }
        }
        return false;
    }

    // 삽입
    public boolean insert(int data) {
        Node newNode = new Node(data);

        // 루트 노드가 null일 경우 바로 root에 새로운 노드 삽입
        if (root == null) {
            root = newNode;
        } else {
            // 루트 노드가 있을 경우 그 밑에 서브트리 탐색
            Node parent = null;
            Node head = root;

            // 리프 노드까지 내려 가기
            while (head != null) {
                if (head.getData() > data) {
                    parent = head;
                    head = head.getLeft();
                } else if (head.getData() < data) {
                    parent = head;
                    head = head.getRight();
                    // 값이 기존에 있으면 삽입 하지 않기
                } else {
                    return false;
                }
            }

            // 리프 노드에서 삽입하기
            if (parent.getData() > data) {
                parent.setLeft(newNode);
            } else {
                parent.setRight(newNode);
            }
        }
        return true;
    }

    // 삭제
    public boolean delete(int data) {
        // 트리에 찾는 데이터가 없으면 false 반환
        if (!find(data)) {
            return false;
        } else {
            Node parent = null;
            Node head = root;

            while (head.getData() != data) {
                if (head.getData() > data) {
                    parent = head;
                    head = head.getLeft();
                } else {
                    parent = head;
                    head = head.getRight();
                }
            }

            // 삭제할 노드가 단말 노드인 경우
            if (head.getChildSize() == 0) {
                // 삭제할 노드가 루트 노드 일 때
                if (parent == null) {
                    // 루트 노드에 null 삽입
                    root = null;
                    // 루트 노드가 아닐 때
                } else {
                    // Parent 노드에서 head 가 왼쪽인지 오른쪽인지 확인 후 null 삽입
                    if (parent.getLeft() == head) {
                        parent.setLeft(null);
                    } else {
                        parent.setRight(null);
                    }
                }
            // 삭제할 노드가 한 개의 자식 노드를 가진 경우
            } else if (head.getChildSize() == 1) {
                boolean isToLeft = head.getLeft() != null;
                // 삭제할 노드가 루트 노드일 때
                if (parent == null) {
                    if (isToLeft) {
                        root = head.getLeft();
                    } else {
                        root = head.getRight();
                    }

                // 삭제할 노드가 부모의 왼쪽 자식 노드 일 때
                } else if (parent.getLeft() == head) {
                    // 삭제할 노드의 자식이 왼쪽에 있을 때
                    if (isToLeft) {
                        parent.setLeft(head.getLeft());
                    } else {
                    // 삭제할 노드의 자식이 오른쪽에 있을 때
                        parent.setLeft(head.getRight());
                    }
                // 삭제할 노드가 부모의 오른쪽 자식 노드 일 때
                } else {
                    // 삭제할 노드의 자식이 왼쪽에 있을 때
                    if (isToLeft) {
                        parent.setRight(head.getLeft());
                    } else {
                        // 삭제할 노드의 자식이 오른쪽에 있을 때
                        parent.setRight(head.getRight());
                    }
                }
            // 삭제할 노드가 두 개의 자식 노드를 가진 경우
            } else {
                // 오른쪽에서 가장 작은 노드를 가져옴
                Node right = head.getRight();
                Node minimum = getMinimum(head.getRight());
                if (parent == null) {
                    root = minimum;
                } else if (parent.getLeft() == head) {
                    parent.setLeft(minimum);
                } else {
                    parent.setRight(minimum);
                }
                minimum.setRight(right);

                if (minimum == right) {
                    minimum.setRight(null);
                }
                minimum.setLeft(head.getLeft());
            }
        }
        return true;
    }

    public Node getMinimum(Node deleteNode) {
        Node parent = deleteNode;
        Node head = deleteNode;
        while (head.getLeft() != null) {
            parent = head;
            head = head.getLeft();
        }
        parent.setLeft(null);
        return head;
    }
}