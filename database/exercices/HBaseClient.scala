import org.apache.hadoop.hbase.{HBaseConfiguration, TableName}
import org.apache.hadoop.fs.Path
import org.apache.hadoop.hbase.client.{ConnectionFactory, Get, Result, Scan, Table}
import org.apache.hadoop.hbase.util.Bytes
import scala.collection.mutable.ListBuffer

case class Contact(personalName: String, personalPhone: String, officePhone: String, officeAddress: String)

// Result to contact Object

def toContact(result: Result): Contact = {
	val personalName = result.getValue(Bytes.toBytes("Personal"), Bytes.toBytes("Name"))
	val personalPhone = result.getValue(Bytes.toBytes("Personal"), Bytes.toBytes("Phone"))
	val officePhone = result.getValue(Bytes.toBytes("Office"), Bytes.toBytes("Phone"))
	val officeAddress = result.getValue(Bytes.toBytes("Office"), Bytes.toBytes("Address"))

	Contact(Bytes.toString(personalName), Bytes.toString(personalPhone), Bytes.toString(officePhone), Bytes.toString(officeAddress))
}

def getElement(table: Table, key: String) : Contact = {
	val get = new Get(Bytes.toBytes(key));
	val result = table.get(get)
	toContact(result)
}

// Scan a table and retrieve all records

def getAll(table: Table) : ListBuffer[Contact] = {
	var contacts = ListBuffer[Contact]()

	// Instantiating the Scan class + Getting the scan result
	val scan = new Scan()
	val scanner = table.getScanner(scan)

	var result = scanner.next
	while ( {
	  result != null
	}) {
	  contacts += toContact(result)
	  result = scanner.next
	}

	scanner.close()
	contacts
}

// Define Configuration

val confH = HBaseConfiguration.create()
confH.addResource(new Path("/etc/hadoop/conf.empty/core-site.xml"))
confH.addResource(new Path("/etc/hbase/conf.dist/hbase-site.xml"))

// Define Connection

val connection = ConnectionFactory.createConnection(confH)
