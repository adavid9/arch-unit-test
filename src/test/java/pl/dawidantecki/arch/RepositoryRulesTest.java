package pl.dawidantecki.arch;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.runner.RunWith;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

/**
 * @author: Dawid Antecki
 * @created: 03/19/2021 8:10 PM
 * @version: 1.0
 */
@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "pl.dawidantecki.arch")
public class RepositoryRulesTest {

    @ArchTest
    public static final ArchRule repositories_should_end_with_the_word_repository =
            classes().that().resideInAPackage("..repository").should().haveNameMatching(".*Repository");

    @ArchTest
    public static final ArchRule repositories_should_be_interfaces = classes().that().resideInAPackage("..repository")
            .should().beInterfaces();
}
