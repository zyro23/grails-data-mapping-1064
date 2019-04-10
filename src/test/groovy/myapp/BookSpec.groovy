package myapp

import grails.test.hibernate.HibernateSpec
import org.hibernate.exception.ConstraintViolationException

class BookSpec extends HibernateSpec {

	def "test unique constraint validation with auto flush"() {
		Author author = new Author(name: "author")
		author.addToBooks(new Book(name: "book"))
		author.save failOnError: true, flush: true

		when:
		Book book = new Book(name: "book")
		author.addToBooks book
		book.save()

		then:
		notThrown ConstraintViolationException
		book.errors
	}

}
