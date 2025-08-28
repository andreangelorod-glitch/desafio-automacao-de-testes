import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CadastroUsuarioTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:8080");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testCadastroBuscaExclusao() throws InterruptedException {
        String nome = "QA Teste";
        String cpf = "81937387054";
        String celular = "11989999999";
        String nascimento = "21/02/1999";


        // -------- Criar novo usuário --------
        driver.findElement(By.id("nome")).sendKeys(nome);
        driver.findElement(By.id("cpf")).sendKeys(cpf);
        driver.findElement(By.id("celular")).sendKeys(celular);
        driver.findElement(By.id("dt-nascimento")).sendKeys(nascimento);
        Thread.sleep(4000);

        driver.findElement(By.id("btn-salvar")).click();

        Thread.sleep(5000); // aguardar atualização da lista

        // -------- Buscar usuário --------
        driver.findElement(By.id("input-search")).sendKeys(nome);
        driver.findElement(By.xpath("//*[@id=\"app\"]/form[2]/button")).click();
        Thread.sleep(1000);

        // -------- Excluir todos usuários --------
        List<WebElement> botoesExcluir = driver.findElements(By.xpath("//*[@id=\"app\"]/button"));
        for (WebElement botao : botoesExcluir) {
            botao.click();
            Thread.sleep(500);
        }

    }
}