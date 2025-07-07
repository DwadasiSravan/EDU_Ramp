import java.util.List;

interface DocVerifier {
    boolean verify(List<String> providedDocs, List<String> requiredDocs);
}